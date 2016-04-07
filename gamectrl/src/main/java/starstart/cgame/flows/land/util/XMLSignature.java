package starstart.cgame.flows.land.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.apache.felix.ipojo.util.Log;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.XMLUtils;
import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import cfca.util.KeyUtil;
import cfca.x509.certificate.X509Cert;
import cfca.x509.certificate.X509CertHelper;

public class XMLSignature {

	public XMLSignature() {
		super();
		org.apache.xml.security.Init.init();
	}

	/**
	 * XML签名
	 *
	 * @param xml
	 *            XML文档原文
	 * @param rootElement
	 *            根元素
	 * @param referenceElement
	 *            引用元素
	 * @param privateKey
	 *            私钥
	 * @return 签名后XML
	 * @throws Exception
	 *
	 * @version 1.0
	 * @since 1.0
	 */
	public Document XMLsign(Document xml, String rootElement, String referenceElement, PrivateKey privateKey) throws Exception {
		Constants.setSignatureSpecNSprefix("ds");
		// 创建签名实例
		org.apache.xml.security.signature.XMLSignature signature = new org.apache.xml.security.signature.XMLSignature(xml, "",
				org.apache.xml.security.signature.XMLSignature.ALGO_ID_SIGNATURE_RSA);
		signature.getSignedInfo().addResourceResolver(new OfflineResolver());

		// 创建Transforms，对引用的资源做转换
		Transforms transforms = new Transforms(xml);
		transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);

		// 创建Reference
		signature.addDocument("#" + referenceElement, transforms, Constants.ALGO_ID_DIGEST_SHA1);

		// 签名
		signature.sign(privateKey);

		// 将签名元素添加至根节点
		Node root = xml.getElementsByTagName(rootElement).item(0);
		root.appendChild(signature.getElement());

		return xml;
	}

	/**
	 * XML签名
	 *
	 * @param bytes
	 *            XML文档字节数组
	 * @param rootElement
	 *            根元素
	 * @param referenceElement
	 *            引用元素
	 * @param privateKey
	 *            私钥
	 * @return 签名后XML字节数组
	 * @throws Exception
	 *
	 * @version 1.0
	 * @since 1.0
	 */
	public byte[] XMLsign(byte[] bytes, String rootElement, String referenceElement, String pfxPath, String pwd) throws Exception {
		Document xml = bytes2Document(bytes);
		PrivateKey privateKey = (PrivateKey) getPriKey(pfxPath, pwd);
		XMLsign(xml, rootElement, referenceElement, privateKey);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		XMLUtils.outputDOM(xml, bos);

		return bos.toByteArray();
	}

	private Document bytes2Document(byte[] bytes) throws Exception {
		InputStream is = IOUtils.toInputStream(new String(bytes), "UTF-8");
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		docBuilderFactory.setNamespaceAware(true);
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		return docBuilder.parse(is);
	}

	/**
	 * XML签名验证
	 *
	 * @param xml
	 *            XML文档
	 * @param publicKey
	 *            公钥
	 * @return 验签成功或失败
	 * @throws Exception
	 *
	 * @version 1.0
	 * @since 1.0
	 */
	public boolean XMLverify(Document xml, PublicKey publicKey) throws Exception {
		// 查找Signature元素，如果为空，验签失败
		Element namespaceContext = XMLUtils.createDSctx(xml, "ds", Constants.SignatureSpecNS);
		Element signatureElement = (Element) XPathAPI.selectSingleNode(xml, "//ds:Signature[1]", namespaceContext);
		if (signatureElement == null) {
			return false;
		}

		// 验签
		org.apache.xml.security.signature.XMLSignature signature = new org.apache.xml.security.signature.XMLSignature(signatureElement, "");
		return signature.checkSignatureValue(publicKey);

	}

	public boolean XMLverify(String xml, String cerPath) throws Exception {
		PublicKey publicKey = (PublicKey) getPubKey(cerPath);
		return XMLverify(String2Document(xml), publicKey);
	}

	private Key getPriKey(String pfxPath, String pwd) throws Exception {
		Key priKey = KeyUtil.getPrivateKeyFromPFX(pfxPath, pwd);
		return priKey;
	}

	private Key getPubKey(String cerPath) throws Exception {
		X509Cert cert = X509CertHelper.parse(cerPath);
		Key pubKey = cert.getPublicKey();
		return pubKey;
	}

	private Document String2Document(String xml) throws Exception {
		InputStream is = IOUtils.toInputStream(xml, "UTF-8");
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		docBuilderFactory.setNamespaceAware(true);
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		return docBuilder.parse(is);
	}

}

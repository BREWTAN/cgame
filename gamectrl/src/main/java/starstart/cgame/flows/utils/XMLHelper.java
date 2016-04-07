package starstart.cgame.flows.utils;

import java.util.HashMap;
import java.util.Map;

import starstart.cgame.flows.nsttl.exception.SettleException;

import com.ximpleware.AutoPilot;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;

public class XMLHelper {

	public static Map<String, String> buildMsg(String bodyXml) {
		Map<String, String> result = null;
		try {
			result = new HashMap<>();
			VTDGen vg = new VTDGen();
			vg.setDoc(bodyXml.getBytes("UTF-8"));
			vg.parse(false);
			VTDNav vn = vg.getNav();
			AutoPilot ap = new AutoPilot(vn);
			ap.selectXPath("/Root/*");

			while ((ap.evalXPath()) != -1) {
				String key = vn.toString(vn.getCurrentIndex());
				String value = null;
				int t = vn.getText();
				if (t != -1) {
					value = vn.toNormalizedString(t);
				}
				result.put(key, value);
			}

		} catch (Exception e) {
			throw new SettleException("5000", e);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(XMLHelper.buildMsg("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<Root>" + "<Version>1.0.0</Version>" + "<InstId>12345</InstId>"
				+ "<MessageId>14022512230132500000</MessageId>" + "<CertId>LT01Req</CertId>" + "<AcctName>王立志</AcctName>" + "<AcctNameEn></AcctNameEn>"
				+ "</Root >"));
	}
}

package starstart.cgame.flows.land.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


/**
 * bean 和 xml 之间的转换工具
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Create Date: Jul 10, 2012</p>
 * <p>Company: umbpay</p>
 * <p>@author zhangqiang zhangqiang@cjitec.com <p>
 * <p>@version v1.0 <p>
 */
public class BeanToXmlUtil {
	
//	public static <T> T getBeanFormXml(Class<T> className,String rootLableName,String xml) throws Exception{
//		BeanReader beanReader = new BeanReader();
//		beanReader.registerBeanClass(rootLableName,className);
//		T bean = (T)beanReader.parse(new InputSource(new StringReader(xml)));
//		
//		return bean;
//
//	}
	
	public static String getXmlString(Node node) throws Exception{
		StringWriter outputWriter = new StringWriter();
		OutputFormat outputFormat = new OutputFormat();
		outputFormat.setExpandEmptyElements(true);
		XMLWriter writer = new XMLWriter(outputWriter,outputFormat);
		try {
			writer.write(node);
			return outputWriter.toString();
		} catch (IOException e) {

			throw e;
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
				
					throw e;
				}
			}
		}
		
	}
	
	public static String getXmlString(Document node) throws Exception{
		StringWriter outputWriter = new StringWriter();
		OutputFormat outputFormat = new OutputFormat();
		outputFormat.setExpandEmptyElements(true);
		XMLWriter writer = new XMLWriter(outputWriter,outputFormat);
		try {
			writer.write(node);
			return outputWriter.toString();
		} catch (IOException e) {
		
			throw e;
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
				
					throw e;
				}
			}
		}
		
	}
	private static final Map<Class<?>, JAXBContext> JAXB_CONTEXT_CACHE = new ConcurrentHashMap<Class<?>, JAXBContext>();

    /**
     * 将JavaBean转换为XML文档
     *
     * @param object
     *        待转换的JavaBean对象
     * @param clazz
     *        XML文档根节点Class
     * @return 生成的XML文档内容
     */
    public static String marshal(Object object, Class<?> clazz) {
        if (object == null) {
            return StringUtils.EMPTY;
        }

        StringWriter out = new StringWriter();

        try {
            JAXBContext jaxbContext = getJAXBContext(clazz);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, out);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return out.toString();
    }
    /**
     * 将JavaBean转换为XML文档
     *
     * @param object
     *        待转换的JavaBean对象
     * @param clazz
     *        XML文档根节点Class
     * @return 生成的XML文档内容
     */
    public static String marshalUnformat(Object object, Class<?> clazz) {
        if (object == null) {
            return StringUtils.EMPTY;
        }

        StringWriter out = new StringWriter();

        try {
            JAXBContext jaxbContext = getJAXBContext(clazz);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            marshaller.marshal(object, out);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return out.toString();
    }
    /**
     * 将JavaBean转换为XML文档
     *
     * @param object
     *        待转换的JavaBean对象
     * @param clazz
     *        XML文档根节点Class
     * @return 生成的XML文档内容
     */
    public static String marshalGBK(Object object, Class<?> clazz) {
        if (object == null) {
            return StringUtils.EMPTY;
        }

        StringWriter out = new StringWriter();

        try {
            JAXBContext jaxbContext = getJAXBContext(clazz);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            marshaller.marshal(object, out);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return out.toString();
    }
    
    /**
     * 将JavaBean转换为XML文档,无xml头
     *
     * @param object
     *        待转换的JavaBean对象
     * @param clazz
     *        XML文档根节点Class
     * @return 生成的XML文档内容
     */
    public static String marshalWithoutHead(Object object, Class<?> clazz) {
        if (object == null) {
            return StringUtils.EMPTY;
        }

        StringWriter out = new StringWriter();

        try {
            JAXBContext jaxbContext = getJAXBContext(clazz);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(object, out);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return out.toString();
    }

    /**
     * 将JavaBean转换为XML文档，并保存到文件里
     *
     * @param object
     *        待转换的JavaBean对象
     * @param clazz
     *        XML文档根节点Class
     * @param xmlFile
     *        保存xml文档的文件
     * @return 生成的XML文档内容
     */
    public void marshal(Object object, Class<?> clazz, File xmlFile) {
        if (object == null) {
            return;
        }
        if (xmlFile == null) {
            return;
        }

        try {
            JAXBContext jaxbContext = getJAXBContext(clazz);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(object, xmlFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    private static JAXBContext getJAXBContext(Class<?> clazz) {
        JAXBContext jaxbContext = JAXB_CONTEXT_CACHE.get(clazz);

        if (jaxbContext == null) {
            try {
                jaxbContext = JAXBContext.newInstance(clazz);
                JAXB_CONTEXT_CACHE.put(clazz, jaxbContext);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }

        return jaxbContext;
    }

    /**
     * 将XML解析为JavaBean
     *
     * @param xml
     *        XML文档内容
     * @param clazz
     *        XML文档根节点Class
     * @return 解析结果
     */
    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(String xml, Class<T> clazz) {
        if (StringUtils.isBlank(xml)) {
            return null;
        }

        Object object = null;

        try {
            JAXBContext jaxbContext = getJAXBContext(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            object = unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return (T) object;
    }

    /**
     * 将XML文件解析为JavaBean
     *
     * @param xmlFile
     *        XML文件
     * @param clazz
     *        XML文档根节点Class
     * @return 解析结果
     */
    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(File xmlFile, Class<T> clazz) {
        if (xmlFile == null) {
            return null;
        }

        Object object = null;

        try {
            JAXBContext jaxbContext = getJAXBContext(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            object = unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return (T) object;
    }

    /**
     * 将XML文件解析为JavaBean
     *
     * @param xmlFile
     *        XML文件
     * @param clazz
     *        XML文档根节点Class
     * @return 解析结果
     */
    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(InputStream xmlFile, Class<T> clazz) {
        if (xmlFile == null) {
            return null;
        }

        Object object = null;

        try {
            JAXBContext jaxbContext = getJAXBContext(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            object = unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return (T) object;
    }
}

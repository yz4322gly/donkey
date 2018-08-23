//package xin.tomdonkey.sax;
//
//
//
//
//import javax.sql.rowset.spi.XmlReader;
//import javax.xml.bind.ValidationEventHandler;
//
//public class XmlValidator
//{
//    StringBuilder sb;
//    public  String XmlValidationByXsd(String XmlPath,String XsdPath)
//    {
//        sb= new StringBuilder();
//        String strReturnValue = String.Empty;
//
//        String dataFile = XmlPath;
//        String schemaFile = XsdPath;
//        //备注：这里为xsd验证文件里的命名空间targetNamespace
//        String namespaceUrl = "http://www.xxx.cn/xxx";
//
//        XmlReaderSettings settings = new XmlReaderSettings();
//        settings.ValidationType = ValidationType.Schema;
//        settings.Schemas.Add(namespaceUrl, schemaFile);
//        settings.ValidationEventHandler += new ValidationEventHandler(settings_ValidationEventHandler);
//
//        String errorMessage = "这不是一个合乎规范的数据文件";
//
//        XmlReader reader = XmlReader.Create(dataFile, settings);
//        try
//        {
//            reader.MoveToContent();
//            while (reader.Read())
//            {
//                if (reader.NodeType == XmlNodeType.Document && reader.NamespaceURI != namespaceUrl)
//                {
//                    strReturnValue = errorMessage;
//                    break;
//                }
//            }
//        }
//        catch (XmlException ex)
//        {
//            sb.AppendFormat("{0}\n", ex.Message);
//        }
//        finally
//        {
//            reader.Close();
//        }
//
//        if (sb.Length == 0)
//            strReturnValue = "true";
//        else
//            strReturnValue = sb.ToString();
//
//        return strReturnValue;
//    }
//
//    void settings_ValidationEventHandler(object sender, System.Xml.Schema.ValidationEventArgs e)
//    {
//        sb.AppendFormat("{0}\n", e.Message);
//    }
//}

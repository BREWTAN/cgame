package ${packageName}.so

import onight.async.mysql.commons.SimpleDAO
import scala.reflect.classTag
import java.math.BigDecimal
import java.sql.Timestamp


object ${packShortName}DAOs {

<#list clazzinfos as clazzinfo >

  case class KO${clazzinfo.domainClass}(
  <#list clazzinfo.columnInfos as colinfo> 
  			<#if colinfo_index == 0><#else>,</#if> val ${colinfo.sofield}: ${colinfo.sotype} = null
  </#list>
  	)

  object ${clazzinfo.domainClass}DAO extends SimpleDAO[KO${clazzinfo.domainClass}] {
    val ttag = classTag[KO${clazzinfo.domainClass}];
    val tablename = "${clazzinfo.tablename}";
    val keyname = "${clazzinfo.keycol}"
  }

</#list>

}
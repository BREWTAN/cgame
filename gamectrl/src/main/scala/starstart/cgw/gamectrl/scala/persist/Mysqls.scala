package starstart.cgw.gamectrl.scala.persist

import onight.osgi.annotation.NActorProvider
import onight.tfw.ojpa.api.annotations.StoreDAO
import onight.tfw.ojpa.api.OJpaDAO
import onight.scala.commons.SessionModules
import scala.beans.BeanProperty
import onight.tfg.ordbgens.tlt.entity.TLTCoreBet
import com.google.protobuf.Message
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlows
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.tfg.ordbgens.sys.entity.TSysParam
import org.apache.commons.lang3.StringUtils
import onight.tfg.ordbgens.tlt.entity.TLTCoreWin
import onight.tfg.ordbgens.tlt.entity.TLTCoreRewardExample
import onight.tfg.ordbgens.tlt.entity.TLTCoreReward

@NActorProvider
object Mysqls extends SessionModules[Message] {

  @StoreDAO(domain = classOf[TLTCoreBet], target = "cmysql")
  @BeanProperty
  var corebetDAO: OJpaDAO[TLTCoreBet] = null

  @StoreDAO(domain = classOf[TLTCoreWin], target = "cmysql")
  @BeanProperty
  var corewinDAO: OJpaDAO[TLTCoreWin] = null

  @StoreDAO(domain = classOf[TLTCoreReward], target = "cmysql")
  @BeanProperty
  var corerewardDAO: OJpaDAO[TLTCoreReward] = null

  
  @StoreDAO(domain = classOf[TLTIssueFlows], target = "cmysql")
  @BeanProperty
  var issueflowDAO: OJpaDAO[TLTIssueFlows] = null

  @StoreDAO(domain = classOf[TLTIssueSteps], target = "cmysql")
  @BeanProperty
  var issuestepsDAO: OJpaDAO[TLTIssueSteps] = null

  @StoreDAO(domain = classOf[TLTIssue], target = "cmysql")
  @BeanProperty
  var issuesDAO: OJpaDAO[TLTIssue] = null

  @StoreDAO(domain = classOf[TSysParam], target = "cmysql")
  @BeanProperty
  var paramDAO: OJpaDAO[TSysParam] = null

  def getParamStr(key: String, defaultv: String = ""): String = {
    if (StringUtils.isBlank(key)) {
      return defaultv;
    }
    val ret = paramDAO.selectByPrimaryKey(key.trim());
    if (ret != null) {
      return StringUtils.trim(ret.getParamValue)
    }
    return defaultv;
  }
  def getParamInt(key: String, defaultv: Int = 0): Int = {
    val vstr = getParamStr(key);
    if (StringUtils.isBlank(vstr)) {
      return defaultv;
    }
    try {
      return Integer.parseInt(vstr)
    } catch {
      case _: Throwable =>
    }
    return defaultv
  }

  def getParamFloat(key: String, defaultv: Float = 0): Float = {
    val vstr = getParamStr(key);
    if (StringUtils.isBlank(vstr)) {
      return defaultv;
    }
    try {
      return vstr.toFloat
    } catch {
      case _: Throwable =>
    }
    return defaultv
  }

}
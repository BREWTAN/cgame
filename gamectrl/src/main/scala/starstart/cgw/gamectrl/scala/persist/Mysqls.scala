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

@NActorProvider
object Mysqls extends SessionModules[Message] {

  @StoreDAO(domain = classOf[TLTCoreBet], target = "cmysql")
  @BeanProperty
  var corebetDAO: OJpaDAO[TLTCoreBet] = null

  @StoreDAO(domain = classOf[TLTIssueFlows], target = "cmysql")
  @BeanProperty
  var issueflowDAO: OJpaDAO[TLTIssueFlows] = null

  @StoreDAO(domain = classOf[TLTIssueSteps], target = "cmysql")
  @BeanProperty
  var issuestepsDAO: OJpaDAO[TLTIssueSteps] = null

  @StoreDAO(domain = classOf[TLTIssue], target = "cmysql")
  @BeanProperty
  var issuesDAO: OJpaDAO[TLTIssue] = null
}
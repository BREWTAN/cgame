package starstart.cgw.scala.service

import com.google.protobuf.Message
import onight.osgi.annotation.NActorProvider
import onight.scala.commons.SessionModules
import onight.tfw.ojpa.api.annotations.StoreDAO
import onight.tfw.ojpa.api.OJpaDAO
import scala.beans.BeanProperty
import onight.tfg.ordbgens.tlt.entity.TLTCoreBet
import onight.tfg.ordbgens.tlt.entity.TLTCoreTicket

@NActorProvider
object MysqlDaos extends SessionModules[Message] {

  @StoreDAO(domain = classOf[TLTCoreBet],target = "cmysql")
  @BeanProperty
  var corebetDAO: OJpaDAO[TLTCoreBet] = null

  
    @StoreDAO(domain = classOf[TLTCoreTicket],target = "cmysql")
  @BeanProperty
  var coreticketDAO: OJpaDAO[TLTCoreTicket] = null
  
}
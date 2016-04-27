package starstart.cgw.scala.service

import com.google.protobuf.Message
import onight.osgi.annotation.NActorProvider
import onight.scala.commons.SessionModules
import onight.tfw.ojpa.api.annotations.StoreDAO
import onight.tfw.ojpa.api.OJpaDAO
import scala.beans.BeanProperty
import onight.tfw.otransio.api.PSender
import onight.tfw.otransio.api.IPacketSender

@NActorProvider
object Sender extends SessionModules[Message] {
  
  
   override def getCmds(): Array[String] = Array( "***" )

  @BeanProperty
  @PSender
  var ps: IPacketSender = null;

}
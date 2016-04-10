package onight.scala.commons

import org.osgi.framework.BundleReference
import com.google.protobuf.Message
import onight.oapi.scala.traits.OLog
import onight.tfw.async.AsyncPBActor
import onight.tfw.async.CompleteHandler
import onight.tfw.otransio.api.beans.FramePacket
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBModule
import onight.oapi.scala.commons.LService

class _SNoneClass {

}
abstract class SessionModules[T <: Message] extends AsyncPBActor[T] with OLog {

  override def getModule: String = PBModule.CGC.name()

  implicit val ctx =
    classOf[BundleReference].cast(classOf[_SNoneClass].getClassLoader())
      .getBundle()
      .getBundleContext();

  def service: LService[T] = null

  override def onPBPacket(pack: FramePacket, pbo: T, handler: CompleteHandler) = {

    try {
      service.onPBPacket(pack, pbo, handler)
    } catch {
      case t: Throwable => { log.error("fato:", t); throw new RuntimeException(t); }
    }
  }
  override def getCmds(): Array[String] = {
    if (service == null)
      Array("")
    else
      Array(service.cmd)

  }
}


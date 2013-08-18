import com.jvmdramas.app.DramaStatus
import grails.converters.JSON

class BootStrap {

  def init = { servletContext ->
    JSON.registerObjectMarshaller(org.joda.time.DateTime) {
      return it?.toString("yyyy-MM-dd'T'HH:mm:ss'Z'")
    }

    JSON.registerObjectMarshaller(DramaStatus) {
      return it.name()
    }
  }
  def destroy = {
  }
}

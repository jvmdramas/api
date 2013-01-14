package com.jvmdramas.app

class DramaCategory {
  String name

  Date dateCreated
  Date lastUpdated

  static hasMany = [dramas: Drama]

  static constraints = {
    name blank: false, maxSize: 100
    dateCreated shared: 'autoTimeStamp'
    lastUpdated shared: 'autoTimeStamp'
  }

  String toString() {
    name
  }
}

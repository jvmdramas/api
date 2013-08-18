package com.jvmdramas.app

class DramaTag {
  String name

  Date dateCreated
  Date lastUpdated

  //static belongsTo = [Drama]
  //static hasMany = [dramas: Drama]

  static constraints = {
    name blank: false, maxSize: 100
    dateCreated shared: 'autoTimeStamp'
    lastUpdated shared: 'autoTimeStamp'
  }

  String toString() {
    name
  }
}

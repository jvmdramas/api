package com.jvmdramas.app

class Drama {
  String title
  String url
  String drama
  DramaStatus status = DramaStatus.PENDING

  Date dateCreated
  Date lastUpdated

  static hasMany = [tags: DramaCategory]

  static constraints = {
    title blank: false, maxSize: 200
    url blank: false, maxSize: 500, url: true
    drama blank: false
    status nullable: false
    dateCreated shared: 'autoTimeStamp'
    lastUpdated shared: 'autoTimeStamp'
  }
  static mapping = {
    drama type: 'text'
  }
}

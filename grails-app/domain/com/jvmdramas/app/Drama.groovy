package com.jvmdramas.app

class Drama {
  String title
  String url
  String drama
  DramaStatus status = DramaStatus.PENDING

  Date dateCreated
  Date lastUpdated

  static constraints = {
    title blank: false, maxSize: 200
    url blank: false, maxSize: 500, url: true
    drama blank: false
    status nullable: false
    dateCreated nullable: true, display: false
    lastUpdated nullable: true, display: false
  }
  static mapping = {
    drama type: 'text'
  }
}

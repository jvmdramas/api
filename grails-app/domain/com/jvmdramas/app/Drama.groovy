package com.jvmdramas.app

import grails.rest.Resource
import org.joda.time.DateTime

@Resource(uri = '/drama', formats = ['json', 'xml'])
class Drama {
  String title
  String url
  String drama
  DramaStatus status = DramaStatus.PENDING
  DateTime raisedOn

  DateTime dateCreated
  DateTime lastUpdated

  //static hasMany = [tags: DramaTag]

  static constraints = {
    title blank: false, maxSize: 200
    url blank: false, maxSize: 500, url: true
    drama blank: false
    status nullable: false
    raisedOn nullable: false
    dateCreated shared: 'autoTimeStamp'
    lastUpdated shared: 'autoTimeStamp'
  }

  static mapping = {
    drama type: 'text'
  }
}

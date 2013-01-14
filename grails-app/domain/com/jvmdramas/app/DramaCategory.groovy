package com.jvmdramas.app

class DramaCategory {
  String name
  String urlSeo

  Date dateCreated
  Date lastUpdated

  static hasMany = [childCategories: DramaCategory]
  static belongsTo = [parentCategory: DramaCategory]

  static constraints = {
    name blank: false, maxSize: 100
    urlSeo blank: false, maxSize: 100
    dateCreated shared: 'autoTimeStamp'
    lastUpdated shared: 'autoTimeStamp'
  }
}

package com.jvmdramas.app

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Drama)
@Mock([Drama, DramaTag])
class DramaTests {

  void testSomething() {
  }

  void testFoo() {
    Drama vertxDrama = new Drama(
      title: 'vert.x',
      url: 'http://blah.com',
      drama: 'lorem ipsum dolor sit amet consetetur sadipscing elitr sed diam nonumy ' +
        'eirmod tempor invidunt ut labore et dolore magna aliquyam erat sed diam'
    )

    def tags = [
      new DramaTag(name: 'Java'),
      new DramaTag(name: 'JavaScript'),
      new DramaTag(name: 'JRuby'),
      new DramaTag(name: 'Jython'),
      new DramaTag(name: 'Groovy'),
      new DramaTag(name: 'Framework'),
      new DramaTag(name: 'Web development')
    ]

    tags*.save(flush: true)

    assert DramaTag.count() == tags.size()

    tags.each { tag ->
      vertxDrama.addToTags(tag)
    }

    vertxDrama.save(flush: true)

    assert vertxDrama.tags.size() == tags.size()
  }
}

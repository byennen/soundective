package play.modules.soundective.core.utils

import java.io.File
import org.junit._
import org.junit.Assert._
import play.test._

/**
 * Created by IntelliJ IDEA.
 * User: aurelien
 * Date: 12/03/11
 * Time: 12:48
 */
class SongFilterTest extends UnitTest {

  val testedFilter = List("mP3")

  @Test
  def acceptTestTrue {
    assertTrue(SongFilter.accept(new File("test/songs/The Limes - Morning Noon  Night.mp3")))
  }

  @Test
  def typeFilterTestTrue {
    assertTrue(SongFilter.songFilter(new File("test/songs/The Limes - Morning Noon  Night.mp3"), testedFilter))
  }

  @Test
  def typeFilterTestFalse {
    assertFalse(SongFilter.songFilter(new File("test/SongFinderTest.scala"), testedFilter))
  }

  @Test
  def typeFilterTestDirectory {
    //Must accept directories to do the loop
    assertTrue(SongFilter.songFilter(new File("test/"), testedFilter))
  }

  @Test
  def typeFilterTestNotExistDirectory {
    assertFalse(SongFilter.songFilter(new File("patapoum"), testedFilter))
  }

  @Test
  def typeNullFilterTest {
    assertFalse(SongFilter.songFilter(new File("test/songs/The Limes - Morning Noon  Night.mp3"), null))
  }

  @Test
  def typeFilterTestNull {
    assertFalse(SongFilter.songFilter(null, testedFilter))
  }
}
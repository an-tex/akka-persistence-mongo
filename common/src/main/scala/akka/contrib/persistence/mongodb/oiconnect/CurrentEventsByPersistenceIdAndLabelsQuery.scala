package akka.contrib.persistence.mongodb.oiconnect

import akka.NotUsed
import akka.persistence.query.EventEnvelope
import akka.persistence.query.scaladsl.ReadJournal
import akka.stream.scaladsl.Source

trait CurrentEventsByPersistenceIdAndLabelsQuery extends ReadJournal {

  def currentEventsByPersistenceIdAndLabels(
                                             persistenceId: String,
                                             fromSequenceNr: Long,
                                             toSequenceNr: Long,
                                             labels: Seq[String],
                                             maxEvents: Option[Int] = None,
                                             sortAscending: Boolean = true
                                           ): Source[EventEnvelope, NotUsed]
}
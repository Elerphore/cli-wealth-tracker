import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import data.Rule
import data.RulesEnum
import org.bson.Document
import org.litote.kmongo.KMongo
import java.util.logging.Logger

val mongoClient = KMongo.createClient();
val mongoDatabase: MongoDatabase = mongoClient.getDatabase("cli-wealth-tracker")
val mongoCollection: MongoCollection<Document> = mongoDatabase.getCollection("tracker")

fun main(args: Array<String>) {
    val logger = Logger.getGlobal()

    var isApplicationClosed = false

    while(!isApplicationClosed) {
        logger.warning("Enter the rule")
        val input = rule(readln())

        when(input.rule) {
            RulesEnum.MONTH.rule -> {

            }
            RulesEnum.APPLICATION_CLOSED.rule -> { isApplicationClosed = true }
        }
    }
    logger.warning("You closed the application")
}

private fun rule(rule: String): Rule
    = Rule(rule = rule.substringBefore(" ", rule), arguments = rule.substringAfter(" ", rule).split(" "))

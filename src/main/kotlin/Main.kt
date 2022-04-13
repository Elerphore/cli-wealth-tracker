import data.Rule
import java.util.logging.Logger

fun main(args: Array<String>) {
    val logger = Logger.getGlobal()
    var isApplicationClosed = false

    while(!isApplicationClosed) {
        logger.warning("Enter the rule")
        val input = rule(readln())

        logger.warning("rule: ${input.rule}")
        logger.warning("arguments: ${input.arguments}")

        when(input.rule) {
            RulesEnum.APPLICATION_CLOSED.rule -> { isApplicationClosed = true }
        }
    }
    logger.warning("You closed the application")
}

private fun rule(rule: String): Rule
    = Rule(rule = rule.substringBefore(" ", rule), arguments = rule.substringAfter(" ", rule).split(" "))

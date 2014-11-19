package shiro_test

class StartAPIController {
    def aggregationResultsService

    def index() {
	aggregationResultsService.makeScheduledAPICall()
	redirect(controller: 'admin', action: 'index')
 }
}

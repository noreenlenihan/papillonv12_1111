package shiro_test


/*
* Controller that Admin can use to first start the API
* on specified server that will then refresh every 24 hours
*/
class StartAPIController {
    // define service to be used
    def aggregationResultsService

    /* index page will invoke aggregationResultsService
    * and redirect to admin/index URL 
    */
    def index() {
	aggregationResultsService.makeScheduledAPICall()
	redirect(controller: 'admin', action: 'index')
 }
}

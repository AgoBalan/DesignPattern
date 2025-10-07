  System.out.println("This is a demo test.");

         Webdriver is intialized using 
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        Singleton design Pattern
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //From the test case, we call 1 class and from this class object we call other classes
        //like getNavigationBar() and getFooterNavigation()
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        THis is single page responsibility principle.
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

        travelHomePage.goTo();
        travelHomePage.getNavigationBar().setFlights();
        travelHomePage.getFooterNavigation().setFlights();

        /*******************************************************************
         *  STEP 1:
         * Calling each class files directly to execute corresponding methods
         * *******************************************************************/
        // travelHomePage.getMultiTrip().checkFlightAvailability("MAA","HYD");
        //travelHomePage.getRoundTrip().checkFlightAvailability("MAA","HYD");

        /*******************************************************************
         *  STEP 2:
         * Calling each class files directly is not efficient way
         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         * Hence we can go with Next approach of strategy design pattern.
         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         * At run time we decide which implementation to be used.
         * So we can avoid creating getMultiTrip() and getRoundTrip() methods.Less code
         ********************************************************************/
        //By secElement= By.id("traveller-home");
        //travelHomePage.setBookingStrategy(new MultiTrip(driver,secElement));
        //travelHomePage.bookFlight("MAA","HYD");

        /*******************************************************************
         * STEP 3:
         * However the above approach is not the best one as we are exposing
         *the implementation classes to the test class and defining secElement in Testcase
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         * Another approach is to go with Factory Design Pattern
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         ********************************************************************/
         travelHomePage.setBookingStrategyWithPageFactory("MultiTrip");

        /*******************************************************************
         * Passing city as argument is not advisable as multi trip has multiple destination
         *******************************************************************/
        // travelHomePage.bookFlight("MAA","HYD");

        /*******************************************************************
         * STEP 4:
         * Hence use hashmap to pass multiple values
         *******************************************************************/
         /*HashMap<String,String> reservationDetails2 = new HashMap<>();
         reservationDetails2.put("from","MAA");
         reservationDetails2.put("to","HYD");
         reservationDetails2.put("to2","BLR");
         travelHomePage.bookFlight(reservationDetails2);
         */

        /*******************************************************************
         * STEP 5:
         * But still there is problem in above, why to hardcode teh data, rather parameterize it
         *******************************************************************/
        travelHomePage.bookFlight(fromTopReservationDetails);

        /*******************************************************************
         *  STEP 6:
         * Multitrip class internally uses execute around pattern to avoid code duplication
         * Go and check that class
         */

    }

    @DataProvider()
    public Object[][] getData() throws IOException {
       /*******************************************************************
        HashMap<String, String> reservationDetails = new HashMap<>();
        reservationDetails.put("from", "MAA");
        reservationDetails.put("to", "HYD");
        reservationDetails.put("to2", "BLR");

        HashMap<String, String> reservationDetails2 = new HashMap<>();
        reservationDetails2.put("from", "BLR");
        reservationDetails2.put("to", "MAA");
        reservationDetails2.put("to2", "CBE");

        List<HashMap<String,String>> llist = new ArrayList();
        llist.add(reservationDetails);
        llist.add(reservationDetails2);

        //Use either way to pass data
       // return new Object[][]{{reservationDetails}, { reservationDetails2}};

        return new Object[][]{ {llist.get(0)}, {llist.get(1)}};
        *******************************************************************/

        /*******************************************************************
         *  STEP 7:
         * Still there is problem, why pass data from data provide from inside,
         *I want to pass it from external file
         *Go and check DataDrivenTest class
         *******************************************************************/
        List<HashMap<String,String>> llist = getJsonData("src/test/resources/TestData/flightBooking.json");
        return new Object[][]{ {llist.get(0)}, {llist.get(1)}};
    }
    @AfterTest()
    public void tearDown(){
        driver.quit();
    }

    /************************************************************************
     *STEP 8:
     * Export as jar and use it in other projects
     *  mvn clean install -> jar file will be created in local maven repository .m2
     * ************************************************************************/

    /************************************************************************
     *STEP 9:
     * Push jar to jFrog Artifactory and use it in other projects
     *  Set up Maven Project in jfrog
     *  Artifacts->artifactory-> set me up
     *  Deploy tab will have dependency to be added to our project POM file
     *  Then click geenrate settings, it gives settings.xml file
     *  copy and place settings.xml in your lcoal .m2 folder settings.xml
     *  then run teh project mvn deploy -DskipTests
     * Refer the screenshot folder for reference
     * ************************************************************************/

/************************************************************************
 * STEP 10:
 * Push jar using Jenkins job to jFrog Artifactory and use it in other projects
 * Create Jenkins job, link the git project and maven goal as deploy -DskipTests settings="path to .m2/settings.xml
 * Upon run the job jar will be created in jFrog Artifactory
 * ************************************************************************/

/************************************************************************
* STEP 11:
*   Using Jenkins pipeline to push jar to jFrog Artifactory
* 1.Enable Jenkins job to push jar into artifactory using jenkins github hook
* 2.In Jenkins, Goto Settings/System/Github Section/GitHub Servers/Advanced
* 3.Provide webhook URL http://172.27.128.1:9090/github-webhook/  (local IP)
* 4.And enable the same jenkins Job Configure -> select GitHub hook trigger for GITScm polling
* 5.Goto github repo/Settings/Webhooks/Add webhook and save
*  5.1Note: Webhook is private url, Whereas Github can use only public url
*  5.2Inorder to route private to public url use SocketXP application(google and install)
* 6.Download socketXP, signup and login
* 7.https://portal.socketxp.com/#/ copy auth token
* 8.CMD to path where sockexp,exe present ex: C:\socketxp>
* 9.>socketxp login <pastet the Token here>
  Login Succeeded.
  User [jehovabalan@gmail.com] Email [jehovabalan@gmail.com].
  ###To map local port(Jenkins opened port) to public url
  C:\socketxp>socketxp connect http://172.27.128.1:7777  (local jenkins port 7777)
  Connected to SocketXP Cloud Gateway.
  Public URL -> https://jehovaballan-556c5b8eb-91bc-452f-b4e8-d86e6d672842.socketxp.com
10.in github replace previous webhook with this public url
************************************************************************/

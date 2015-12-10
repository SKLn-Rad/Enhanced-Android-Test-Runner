# EATR
The Enhanced Android Test Runner is part of the RySource suite of solutions designed to simplify and
enhance the testing and quality assurance of software development. It gives the test developer the
tools to better align with AGILE practices amongst adding more metadata and verbosity to their
existing framework without sacrificing the standardised approach in which the Android ITR is deployed.

<h2>How it works?</h2>
The EATR extends the existing InstrumentationTestRunner class to provide the same setup and configuration process of a
traditional setup. When extended, the end developer can configure and retrieve callbacks on events by using
the provided annotations or interfaces.

<h3>Report Styles Support</h3>
- Excel Style (Currently in Development)
- JUnit XML (Currently in Development)

<h3>Callbacks</h3>
<i>Implemented using the EnhancedTestInterface</i>
- onTestFailure (Fired upon a test failing an assertion)
- onTestSuppressed (Fired when a test has the @Suppress annotation, normally found during the start of suite execution)
- onTestFinished (Fired upon a test finishing)
- onExecutionFailure (Fired when a test fails to execute completely, normally during Android system events)
- onTestPassed (Fired when a test finishes without hitting any false assertions)
- onTestStarted (Fired when a test starts executing)

<h3>Getting Started, Images and Documentation</h3>
<i>Coming Soon</i>

<h3>Comments or Suggestions?</h3>
Please contact me on ryandixon1993@gmail.com

<h3>Buy me a pint</h3>
<a href="https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=ryandixon1993%40gmail%2ecom&lc=GB&item_name=RySource%20JUnit%204%20Test%20Runner%20%2d%20Donations&no_note=0&currency_code=GBP&bn=PP%2dDonationsBF%3abtn_donate_SM%2egif%3aNonHostedGuest">If this project has helped you as much as it helped me, please feel free to donate.</a>

<h3>Issues?</h3>
Please post a valid log and use the GitHub issues tracker

<h3>Copyright</h3>
The EATR is part of the larger RySource enterprise solution, however the EATR itself is covered under wtfpl license.
<br />
<a href="http://www.wtfpl.net/"><img
       src="http://www.wtfpl.net/wp-content/uploads/2012/12/wtfpl-badge-4.png"
       width="80" height="15" alt="WTFPL" /></a>

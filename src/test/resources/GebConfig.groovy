import geb.report.ScreenshotReporter

reportsDir = "build/geb-reports"
baseUrl = "http://stac2014-ohtacaesar.herokuapp.com"
waiting {
    presets {
        slow {
            timeout = 15
            retryInterval = 1
        }
        quick {
            timeout = 1
        }
    }
}
reporter = new ScreenshotReporter() {
    @Override
    protected escapeFileName(String name) {
        name.replaceAll('[\\\\/:\\*?\\"&lt;>\\|]', '_')
    }
}
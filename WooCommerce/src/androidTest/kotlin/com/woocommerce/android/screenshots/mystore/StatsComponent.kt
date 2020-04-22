package com.woocommerce.android.screenshots.mystore

import com.woocommerce.android.R
import com.woocommerce.android.screenshots.util.Screen

class StatsComponent : Screen {
    companion object {
        const val STATS_DASHBOARD = R.id.dashboard_stats
    }

    constructor(): super(STATS_DASHBOARD)

    override fun recover() {
        super.recover()
        clickOn(R.id.reviews)
        clickOn(R.id.dashboard)
    }

    fun switchToStatsDashboardYearsTab() {
        selectItemWithTitleInTabLayout(R.string.dashboard_stats_granularity_years, R.id.tab_layout, STATS_DASHBOARD)
        // One option to ensure stats load is to idle for n seconds to give time to the network request to
        // finish. The timeout duration may or may not be enough though. Here's an option that hopes to be
        // a bit more flexible. I'm leaving the previous one and this comment for reference, just in case
        // the option doens't prove to more reliable.
//        idleFor(1000) // let stats load
        if (!waitForElementToBeDisplayedWithoutFailure(R.id.dashboard_recency_text)) {
            recover()
            waitForElementToBeDisplayed(R.id.dashboard_recency_text)
        }
    }
}
package com.mkk_app.JUKIR.interfaces;

import com.mkk_app.JUKIR.models.Report;

/**
 *
 * @author rhaihan aditya
 */
public interface IReportable {
    public Report generateReport();
    
    public void exportTo(String format);
}

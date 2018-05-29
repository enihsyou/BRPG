package javabean;

import java.util.List;

/**
 * 被举报帖子集合类
 */
public class ReportedPostList {
    private List<ReportedPost> reportedPostList;//被举报帖子集合

    public List<ReportedPost> getReportedPostList() {
        return reportedPostList;
    }

    public void setReportedPostList(List<ReportedPost> reportedPostList) {
        this.reportedPostList = reportedPostList;
    }
}

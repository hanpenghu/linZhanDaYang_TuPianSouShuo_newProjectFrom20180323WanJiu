package cn.productai.api.pai.entity.search;

import cn.productai.api.core.base.BaseResponse;
import cn.productai.api.pai.response.SearchResult;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created by Thinkpad on 2017/7/4.
 *
 */
public class ImageSearchResponse extends BaseResponse {

    @JsonProperty("results")
    private SearchResult[] results;

    @JsonProperty("ds")
    private String dataSetIndexVersion;

    @JsonProperty("searchtime")
    private double searchTime;

    @JsonProperty("loc")
    private Integer[] location;

    @JsonProperty("download_time")
    private double downloadTime;

    public SearchResult[] getResults() {
        return results;
    }

    public void setResults(SearchResult[] results) {
        this.results = results;
    }

    public String getDataSetIndexVersion() {
        return dataSetIndexVersion;
    }

    public void setDataSetIndexVersion(String dataSetIndexVersion) {
        this.dataSetIndexVersion = dataSetIndexVersion;
    }

    public double getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(double searchTime) {
        this.searchTime = searchTime;
    }

    public Integer[] getLocation() {
        return location;
    }

    public void setLocation(Integer[] location) {
        this.location = location;
    }

    public double getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(double downloadTime) {
        this.downloadTime = downloadTime;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("cn.productai.api.pai.entity.search.ImageSearchResponse{");
        sb.append("results=").append(results == null ? "null" : Arrays.asList(results).toString());
        sb.append(", dataSetIndexVersion='").append(dataSetIndexVersion).append('\'');
        sb.append(", searchTime=").append(searchTime);
        sb.append(", location=").append(location == null ? "null" : Arrays.asList(location).toString());
        sb.append(", downloadTime=").append(downloadTime);
        sb.append('}');
        return sb.toString();
    }
}

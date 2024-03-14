package org.kewlui.demo.ui.TestApp.Model;

/*
MIT License

Copyright (c) 2024 GoFintec Ltd

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/


import com.gofintec.kewlui.base.databinding.ILocalRecord;

/**
 * Example of a table row, used for displaying on the 'real time' updating page
 */

public class RiskReportRow implements ILocalRecord {
    long id = 0; // required - all ids are positive.  Assume 0 as 'unset'
    long seqNum; // required - will be set on update
    Long deletedTime; // if set to a time, we state this row has been deleted

    String symbol;
    String tenor;
    String strike;
    String type;

    Double delta;
    Double gamma;
    Double theta;
    Double vega;
    Double rho;


    @Override
    public long getId () {
        return id;
    }

    @Override
    public void setId (long id) {
        this.id = id;
    }

    @Override
    public long getSeqNum () {
        return seqNum;
    }

    @Override
    public void setSeqNum (long seqNum) {
        this.seqNum = seqNum;
    }

    public Long getDeletedTime () {
        return deletedTime;
    }

    @Override
    public void setDeletedTime (Long deletedTime) {
        this.deletedTime = deletedTime;
    }

    public String getSymbol () {
        return symbol;
    }

    public void setSymbol (String symbol) {
        this.symbol = symbol;
    }

    public String getTenor () {
        return tenor;
    }

    public void setTenor (String tenor) {
        this.tenor = tenor;
    }

    public String getStrike () {
        return strike;
    }

    public void setStrike (String strike) {
        this.strike = strike;
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }


    public Double getDelta () {
        return delta;
    }

    public void setDelta (Double delta) {
        this.delta = delta;
    }

    public Double getGamma () {
        return gamma;
    }

    public void setGamma (Double gamma) {
        this.gamma = gamma;
    }

    public Double getTheta () {
        return theta;
    }

    public void setTheta (Double theta) {
        this.theta = theta;
    }

    public Double getVega () {
        return vega;
    }

    public void setVega (Double vega) {
        this.vega = vega;
    }

    public Double getRho () {
        return rho;
    }

    public void setRho (Double rho) {
        this.rho = rho;
    }

    public RiskReportRow (String symbol, String tenor, String strike, String type, Double delta, Double gamma, Double theta, Double vega, Double rho) {
        this.symbol = symbol;
        this.tenor = tenor;
        this.strike = strike;
        this.type = type;
        this.delta = delta;
        this.gamma = gamma;
        this.theta = theta;
        this.vega = vega;
        this.rho = rho;
    }

    public RiskReportRow () {
    }
}

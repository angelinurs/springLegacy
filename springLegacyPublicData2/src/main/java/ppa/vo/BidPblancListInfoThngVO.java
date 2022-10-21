package ppa.vo;

public class BidPblancListInfoThngVO {
	
	private String bidNtceNo;
	private String bidNtceOrd;
	private String reNtceYn;
	private String rgstTyNm;
	private String ntceKindNm;
	private String intrbidYn;
	private String bidNtceDt;
	private String refNo;
	private String bidNtceNm;
	private String ntceInsttCd;
	private String ntceInsttNm;
	private String dminsttCd;
	private String dminsttNm;
	private String bidMethdNm;
	private String cntrctCnclsMthdNm;
	private String ntceInsttOfclNm;
	private String ntceInsttOfclTelNo;
	private String ntceInsttOfclEmailAdrs;
	private String exctvNm;
	private String bidQlfctRgstDt;
	private String cmmnSpldmdAgrmntRcptdocMethd;
	private String cmmnSpldmdAgrmntClseDt;
	private String cmmnSpldmdCorpRgnLmtYn;
	private String bidBeginDt;
	private String bidClseDt;
	private String opengDt;
	private String ntceSpecDocUrl1;
	private String ntceSpecDocUrl2;
	private String ntceSpecDocUrl3;
	private String ntceSpecDocUrl4;
	private String ntceSpecDocUrl5;
	private String ntceSpecDocUrl6;
	private String ntceSpecDocUrl7;
	private String ntceSpecDocUrl8;
	private String ntceSpecDocUrl9;
	private String ntceSpecDocUrl10;
	private String ntceSpecFileNm1;
	private String ntceSpecFileNm2;
	private String ntceSpecFileNm3;
	private String ntceSpecFileNm4;
	private String ntceSpecFileNm5;
	private String ntceSpecFileNm6;
	private String ntceSpecFileNm7;
	private String ntceSpecFileNm8;
	private String ntceSpecFileNm9;
	private String ntceSpecFileNm10;
	private String rbidPermsnYn;
	private String prdctClsfcLmtYn;
	private String mnfctYn;
	private String prearngPrceDcsnMthdNm;
	private String totPrdprcNum;
	private String drwtPrdprcNum;
	private String asignBdgtAmt;
	private String presmptPrce;
	private String opengPlce;
	private String bidNtceDtlUrl;
	private String bidNtceUrl;
	private String bidPrtcptFeePaymntYn;
	private String bidPrtcptFee;
	private String bidGrntymnyPaymntYn;
	private String crdtrNm;
	private String dtilPrdctClsfcNo;
	private String dtilPrdctClsfcNoNm;
	private String prdctSpecNm;
	private String prdctQty;
	private String prdctUnit;
	private String prdctUprc;
	private String dlvrTmlmtDt;
	private String dlvrDaynum;
	private String dlvryCndtnNm;
	private String purchsObjPrdctList;
	private String untyNtceNo;
	private String cmmnSpldmdMethdCd;
	private String cmmnSpldmdMethdNm;
	private String stdNtceDocUrl;
	private String brffcBidprcPermsnYn;
	private String dsgntCmptYn;
	private String rsrvtnPrceReMkngMthdNm;
	private String arsltApplDocRcptMthdNm;
	private String arsltApplDocRcptDt;
	private String orderPlanUntyNo;
	private String sucsfbidLwltRate;
	private String rgstDt;
	private String bfSpecRgstNo;
	private String infoBizYn;
	private String sucsfbidMthdCd;
	private String sucsfbidMthdNm;
	private String chgDt;
	private String linkInsttNm;
	private String dminsttOfclEmailAdrs;
	private String indstrytyLmtYn;
	private String d2bMngDcmtgOprtnDt;
	private String d2bMngDcmtgOprtnPlce;
	private String d2bMngRgnLmtYn;
	private String d2bMngPblctPlceNm;
	private String d2bMngCntrctKindNm;
	private String d2bMngCntrybndDedtBgnDate;
	private String d2bMngCntrybndDedtEndDate;
	private String d2bMngRsrvtnPrceBssOpenYn;
	private String d2bMngRrsrvtnPrceBssAplYn;
	private String d2bMngBssamt;
	private String d2bMngRgstEvalExmpYn;
	private String d2bMngCompCorpRsrchObjYn;
	private String d2bMngOrgnlbdgtDedtBgnDate;
	private String d2bMngOrgnlbdgtDedtEndDate;
	private String d2bMngAssmntUplmtRt;
	private String d2bMngAssmntLwstlmtRt;
	private String d2bMngStdIndstryClsfcCdList;
	private String d2bMngPrdctnAbltySbmsnClseDt;
	private String d2bMngProgrsSttusNm;
	private String d2bMngExetTyNm;
	private String d2bMngExetTyCd;
	private String d2bMngPrdlstCd;
	private String d2bMngItemNo;
	private String d2bMngNgttnStleNm;
	private String d2bMngNgttnPlanDate;
	private String d2bMngDmndYear;
	private String d2bMngDcsnNo;
	private String chgNtceRsn;
	private String rbidOpengDt;
	private String VAT;
	private String indutyVAT;
	
	
	
	public BidPblancListInfoThngVO() { }
	
	public BidPblancListInfoThngVO(String bidNtceNo, String ntceKindNm, String dminsttNm, String bidMethdNm,
			String cntrctCnclsMthdNm, String ntceInsttOfclNm, String ntceInsttOfclTelNo, String ntceInsttOfclEmailAdrs,
			String exctvNm) {
		this.bidNtceNo = bidNtceNo;
		this.ntceKindNm = ntceKindNm;
		this.dminsttNm = dminsttNm;
		this.bidMethdNm = bidMethdNm;
		this.cntrctCnclsMthdNm = cntrctCnclsMthdNm;
		this.ntceInsttOfclNm = ntceInsttOfclNm;
		this.ntceInsttOfclTelNo = ntceInsttOfclTelNo;
		this.ntceInsttOfclEmailAdrs = ntceInsttOfclEmailAdrs;
		this.exctvNm = exctvNm;
	}
	
	public String getBidNtceNo() {
		return bidNtceNo;
	}
	public void setBidNtceNo(String bidNtceNo) {
		this.bidNtceNo = bidNtceNo;
	}
	public String getBidNtceOrd() {
		return bidNtceOrd;
	}
	public void setBidNtceOrd(String bidNtceOrd) {
		this.bidNtceOrd = bidNtceOrd;
	}
	public String getReNtceYn() {
		return reNtceYn;
	}
	public void setReNtceYn(String reNtceYn) {
		this.reNtceYn = reNtceYn;
	}
	public String getRgstTyNm() {
		return rgstTyNm;
	}
	public void setRgstTyNm(String rgstTyNm) {
		this.rgstTyNm = rgstTyNm;
	}
	public String getNtceKindNm() {
		return ntceKindNm;
	}
	public void setNtceKindNm(String ntceKindNm) {
		this.ntceKindNm = ntceKindNm;
	}
	public String getIntrbidYn() {
		return intrbidYn;
	}
	public void setIntrbidYn(String intrbidYn) {
		this.intrbidYn = intrbidYn;
	}
	public String getBidNtceDt() {
		return bidNtceDt;
	}
	public void setBidNtceDt(String bidNtceDt) {
		this.bidNtceDt = bidNtceDt;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public String getBidNtceNm() {
		return bidNtceNm;
	}
	public void setBidNtceNm(String bidNtceNm) {
		this.bidNtceNm = bidNtceNm;
	}
	public String getNtceInsttCd() {
		return ntceInsttCd;
	}
	public void setNtceInsttCd(String ntceInsttCd) {
		this.ntceInsttCd = ntceInsttCd;
	}
	public String getNtceInsttNm() {
		return ntceInsttNm;
	}
	public void setNtceInsttNm(String ntceInsttNm) {
		this.ntceInsttNm = ntceInsttNm;
	}
	public String getDminsttCd() {
		return dminsttCd;
	}
	public void setDminsttCd(String dminsttCd) {
		this.dminsttCd = dminsttCd;
	}
	public String getDminsttNm() {
		return dminsttNm;
	}
	public void setDminsttNm(String dminsttNm) {
		this.dminsttNm = dminsttNm;
	}
	public String getBidMethdNm() {
		return bidMethdNm;
	}
	public void setBidMethdNm(String bidMethdNm) {
		this.bidMethdNm = bidMethdNm;
	}
	public String getCntrctCnclsMthdNm() {
		return cntrctCnclsMthdNm;
	}
	public void setCntrctCnclsMthdNm(String cntrctCnclsMthdNm) {
		this.cntrctCnclsMthdNm = cntrctCnclsMthdNm;
	}
	public String getNtceInsttOfclNm() {
		return ntceInsttOfclNm;
	}
	public void setNtceInsttOfclNm(String ntceInsttOfclNm) {
		this.ntceInsttOfclNm = ntceInsttOfclNm;
	}
	public String getNtceInsttOfclTelNo() {
		return ntceInsttOfclTelNo;
	}
	public void setNtceInsttOfclTelNo(String ntceInsttOfclTelNo) {
		this.ntceInsttOfclTelNo = ntceInsttOfclTelNo;
	}
	public String getNtceInsttOfclEmailAdrs() {
		return ntceInsttOfclEmailAdrs;
	}
	public void setNtceInsttOfclEmailAdrs(String ntceInsttOfclEmailAdrs) {
		this.ntceInsttOfclEmailAdrs = ntceInsttOfclEmailAdrs;
	}
	public String getExctvNm() {
		return exctvNm;
	}
	public void setExctvNm(String exctvNm) {
		this.exctvNm = exctvNm;
	}
	public String getBidQlfctRgstDt() {
		return bidQlfctRgstDt;
	}
	public void setBidQlfctRgstDt(String bidQlfctRgstDt) {
		this.bidQlfctRgstDt = bidQlfctRgstDt;
	}
	public String getCmmnSpldmdAgrmntRcptdocMethd() {
		return cmmnSpldmdAgrmntRcptdocMethd;
	}
	public void setCmmnSpldmdAgrmntRcptdocMethd(String cmmnSpldmdAgrmntRcptdocMethd) {
		this.cmmnSpldmdAgrmntRcptdocMethd = cmmnSpldmdAgrmntRcptdocMethd;
	}
	public String getCmmnSpldmdAgrmntClseDt() {
		return cmmnSpldmdAgrmntClseDt;
	}
	public void setCmmnSpldmdAgrmntClseDt(String cmmnSpldmdAgrmntClseDt) {
		this.cmmnSpldmdAgrmntClseDt = cmmnSpldmdAgrmntClseDt;
	}
	public String getCmmnSpldmdCorpRgnLmtYn() {
		return cmmnSpldmdCorpRgnLmtYn;
	}
	public void setCmmnSpldmdCorpRgnLmtYn(String cmmnSpldmdCorpRgnLmtYn) {
		this.cmmnSpldmdCorpRgnLmtYn = cmmnSpldmdCorpRgnLmtYn;
	}
	public String getBidBeginDt() {
		return bidBeginDt;
	}
	public void setBidBeginDt(String bidBeginDt) {
		this.bidBeginDt = bidBeginDt;
	}
	public String getBidClseDt() {
		return bidClseDt;
	}
	public void setBidClseDt(String bidClseDt) {
		this.bidClseDt = bidClseDt;
	}
	public String getOpengDt() {
		return opengDt;
	}
	public void setOpengDt(String opengDt) {
		this.opengDt = opengDt;
	}
	public String getNtceSpecDocUrl1() {
		return ntceSpecDocUrl1;
	}
	public void setNtceSpecDocUrl1(String ntceSpecDocUrl1) {
		this.ntceSpecDocUrl1 = ntceSpecDocUrl1;
	}
	public String getNtceSpecDocUrl2() {
		return ntceSpecDocUrl2;
	}
	public void setNtceSpecDocUrl2(String ntceSpecDocUrl2) {
		this.ntceSpecDocUrl2 = ntceSpecDocUrl2;
	}
	public String getNtceSpecDocUrl3() {
		return ntceSpecDocUrl3;
	}
	public void setNtceSpecDocUrl3(String ntceSpecDocUrl3) {
		this.ntceSpecDocUrl3 = ntceSpecDocUrl3;
	}
	public String getNtceSpecDocUrl4() {
		return ntceSpecDocUrl4;
	}
	public void setNtceSpecDocUrl4(String ntceSpecDocUrl4) {
		this.ntceSpecDocUrl4 = ntceSpecDocUrl4;
	}
	public String getNtceSpecDocUrl5() {
		return ntceSpecDocUrl5;
	}
	public void setNtceSpecDocUrl5(String ntceSpecDocUrl5) {
		this.ntceSpecDocUrl5 = ntceSpecDocUrl5;
	}
	public String getNtceSpecDocUrl6() {
		return ntceSpecDocUrl6;
	}
	public void setNtceSpecDocUrl6(String ntceSpecDocUrl6) {
		this.ntceSpecDocUrl6 = ntceSpecDocUrl6;
	}
	public String getNtceSpecDocUrl7() {
		return ntceSpecDocUrl7;
	}
	public void setNtceSpecDocUrl7(String ntceSpecDocUrl7) {
		this.ntceSpecDocUrl7 = ntceSpecDocUrl7;
	}
	public String getNtceSpecDocUrl8() {
		return ntceSpecDocUrl8;
	}
	public void setNtceSpecDocUrl8(String ntceSpecDocUrl8) {
		this.ntceSpecDocUrl8 = ntceSpecDocUrl8;
	}
	public String getNtceSpecDocUrl9() {
		return ntceSpecDocUrl9;
	}
	public void setNtceSpecDocUrl9(String ntceSpecDocUrl9) {
		this.ntceSpecDocUrl9 = ntceSpecDocUrl9;
	}
	public String getNtceSpecDocUrl10() {
		return ntceSpecDocUrl10;
	}
	public void setNtceSpecDocUrl10(String ntceSpecDocUrl10) {
		this.ntceSpecDocUrl10 = ntceSpecDocUrl10;
	}
	public String getNtceSpecFileNm1() {
		return ntceSpecFileNm1;
	}
	public void setNtceSpecFileNm1(String ntceSpecFileNm1) {
		this.ntceSpecFileNm1 = ntceSpecFileNm1;
	}
	public String getNtceSpecFileNm2() {
		return ntceSpecFileNm2;
	}
	public void setNtceSpecFileNm2(String ntceSpecFileNm2) {
		this.ntceSpecFileNm2 = ntceSpecFileNm2;
	}
	public String getNtceSpecFileNm3() {
		return ntceSpecFileNm3;
	}
	public void setNtceSpecFileNm3(String ntceSpecFileNm3) {
		this.ntceSpecFileNm3 = ntceSpecFileNm3;
	}
	public String getNtceSpecFileNm4() {
		return ntceSpecFileNm4;
	}
	public void setNtceSpecFileNm4(String ntceSpecFileNm4) {
		this.ntceSpecFileNm4 = ntceSpecFileNm4;
	}
	public String getNtceSpecFileNm5() {
		return ntceSpecFileNm5;
	}
	public void setNtceSpecFileNm5(String ntceSpecFileNm5) {
		this.ntceSpecFileNm5 = ntceSpecFileNm5;
	}
	public String getNtceSpecFileNm6() {
		return ntceSpecFileNm6;
	}
	public void setNtceSpecFileNm6(String ntceSpecFileNm6) {
		this.ntceSpecFileNm6 = ntceSpecFileNm6;
	}
	public String getNtceSpecFileNm7() {
		return ntceSpecFileNm7;
	}
	public void setNtceSpecFileNm7(String ntceSpecFileNm7) {
		this.ntceSpecFileNm7 = ntceSpecFileNm7;
	}
	public String getNtceSpecFileNm8() {
		return ntceSpecFileNm8;
	}
	public void setNtceSpecFileNm8(String ntceSpecFileNm8) {
		this.ntceSpecFileNm8 = ntceSpecFileNm8;
	}
	public String getNtceSpecFileNm9() {
		return ntceSpecFileNm9;
	}
	public void setNtceSpecFileNm9(String ntceSpecFileNm9) {
		this.ntceSpecFileNm9 = ntceSpecFileNm9;
	}
	public String getNtceSpecFileNm10() {
		return ntceSpecFileNm10;
	}
	public void setNtceSpecFileNm10(String ntceSpecFileNm10) {
		this.ntceSpecFileNm10 = ntceSpecFileNm10;
	}
	public String getRbidPermsnYn() {
		return rbidPermsnYn;
	}
	public void setRbidPermsnYn(String rbidPermsnYn) {
		this.rbidPermsnYn = rbidPermsnYn;
	}
	public String getPrdctClsfcLmtYn() {
		return prdctClsfcLmtYn;
	}
	public void setPrdctClsfcLmtYn(String prdctClsfcLmtYn) {
		this.prdctClsfcLmtYn = prdctClsfcLmtYn;
	}
	public String getMnfctYn() {
		return mnfctYn;
	}
	public void setMnfctYn(String mnfctYn) {
		this.mnfctYn = mnfctYn;
	}
	public String getPrearngPrceDcsnMthdNm() {
		return prearngPrceDcsnMthdNm;
	}
	public void setPrearngPrceDcsnMthdNm(String prearngPrceDcsnMthdNm) {
		this.prearngPrceDcsnMthdNm = prearngPrceDcsnMthdNm;
	}
	public String getTotPrdprcNum() {
		return totPrdprcNum;
	}
	public void setTotPrdprcNum(String totPrdprcNum) {
		this.totPrdprcNum = totPrdprcNum;
	}
	public String getDrwtPrdprcNum() {
		return drwtPrdprcNum;
	}
	public void setDrwtPrdprcNum(String drwtPrdprcNum) {
		this.drwtPrdprcNum = drwtPrdprcNum;
	}
	public String getAsignBdgtAmt() {
		return asignBdgtAmt;
	}
	public void setAsignBdgtAmt(String asignBdgtAmt) {
		this.asignBdgtAmt = asignBdgtAmt;
	}
	public String getPresmptPrce() {
		return presmptPrce;
	}
	public void setPresmptPrce(String presmptPrce) {
		this.presmptPrce = presmptPrce;
	}
	public String getOpengPlce() {
		return opengPlce;
	}
	public void setOpengPlce(String opengPlce) {
		this.opengPlce = opengPlce;
	}
	public String getBidNtceDtlUrl() {
		return bidNtceDtlUrl;
	}
	public void setBidNtceDtlUrl(String bidNtceDtlUrl) {
		this.bidNtceDtlUrl = bidNtceDtlUrl;
	}
	public String getBidNtceUrl() {
		return bidNtceUrl;
	}
	public void setBidNtceUrl(String bidNtceUrl) {
		this.bidNtceUrl = bidNtceUrl;
	}
	public String getBidPrtcptFeePaymntYn() {
		return bidPrtcptFeePaymntYn;
	}
	public void setBidPrtcptFeePaymntYn(String bidPrtcptFeePaymntYn) {
		this.bidPrtcptFeePaymntYn = bidPrtcptFeePaymntYn;
	}
	public String getBidPrtcptFee() {
		return bidPrtcptFee;
	}
	public void setBidPrtcptFee(String bidPrtcptFee) {
		this.bidPrtcptFee = bidPrtcptFee;
	}
	public String getBidGrntymnyPaymntYn() {
		return bidGrntymnyPaymntYn;
	}
	public void setBidGrntymnyPaymntYn(String bidGrntymnyPaymntYn) {
		this.bidGrntymnyPaymntYn = bidGrntymnyPaymntYn;
	}
	public String getCrdtrNm() {
		return crdtrNm;
	}
	public void setCrdtrNm(String crdtrNm) {
		this.crdtrNm = crdtrNm;
	}
	public String getDtilPrdctClsfcNo() {
		return dtilPrdctClsfcNo;
	}
	public void setDtilPrdctClsfcNo(String dtilPrdctClsfcNo) {
		this.dtilPrdctClsfcNo = dtilPrdctClsfcNo;
	}
	public String getDtilPrdctClsfcNoNm() {
		return dtilPrdctClsfcNoNm;
	}
	public void setDtilPrdctClsfcNoNm(String dtilPrdctClsfcNoNm) {
		this.dtilPrdctClsfcNoNm = dtilPrdctClsfcNoNm;
	}
	public String getPrdctSpecNm() {
		return prdctSpecNm;
	}
	public void setPrdctSpecNm(String prdctSpecNm) {
		this.prdctSpecNm = prdctSpecNm;
	}
	public String getPrdctQty() {
		return prdctQty;
	}
	public void setPrdctQty(String prdctQty) {
		this.prdctQty = prdctQty;
	}
	public String getPrdctUnit() {
		return prdctUnit;
	}
	public void setPrdctUnit(String prdctUnit) {
		this.prdctUnit = prdctUnit;
	}
	public String getPrdctUprc() {
		return prdctUprc;
	}
	public void setPrdctUprc(String prdctUprc) {
		this.prdctUprc = prdctUprc;
	}
	public String getDlvrTmlmtDt() {
		return dlvrTmlmtDt;
	}
	public void setDlvrTmlmtDt(String dlvrTmlmtDt) {
		this.dlvrTmlmtDt = dlvrTmlmtDt;
	}
	public String getDlvrDaynum() {
		return dlvrDaynum;
	}
	public void setDlvrDaynum(String dlvrDaynum) {
		this.dlvrDaynum = dlvrDaynum;
	}
	public String getDlvryCndtnNm() {
		return dlvryCndtnNm;
	}
	public void setDlvryCndtnNm(String dlvryCndtnNm) {
		this.dlvryCndtnNm = dlvryCndtnNm;
	}
	public String getPurchsObjPrdctList() {
		return purchsObjPrdctList;
	}
	public void setPurchsObjPrdctList(String purchsObjPrdctList) {
		this.purchsObjPrdctList = purchsObjPrdctList;
	}
	public String getUntyNtceNo() {
		return untyNtceNo;
	}
	public void setUntyNtceNo(String untyNtceNo) {
		this.untyNtceNo = untyNtceNo;
	}
	public String getCmmnSpldmdMethdCd() {
		return cmmnSpldmdMethdCd;
	}
	public void setCmmnSpldmdMethdCd(String cmmnSpldmdMethdCd) {
		this.cmmnSpldmdMethdCd = cmmnSpldmdMethdCd;
	}
	public String getCmmnSpldmdMethdNm() {
		return cmmnSpldmdMethdNm;
	}
	public void setCmmnSpldmdMethdNm(String cmmnSpldmdMethdNm) {
		this.cmmnSpldmdMethdNm = cmmnSpldmdMethdNm;
	}
	public String getStdNtceDocUrl() {
		return stdNtceDocUrl;
	}
	public void setStdNtceDocUrl(String stdNtceDocUrl) {
		this.stdNtceDocUrl = stdNtceDocUrl;
	}
	public String getBrffcBidprcPermsnYn() {
		return brffcBidprcPermsnYn;
	}
	public void setBrffcBidprcPermsnYn(String brffcBidprcPermsnYn) {
		this.brffcBidprcPermsnYn = brffcBidprcPermsnYn;
	}
	public String getDsgntCmptYn() {
		return dsgntCmptYn;
	}
	public void setDsgntCmptYn(String dsgntCmptYn) {
		this.dsgntCmptYn = dsgntCmptYn;
	}
	public String getRsrvtnPrceReMkngMthdNm() {
		return rsrvtnPrceReMkngMthdNm;
	}
	public void setRsrvtnPrceReMkngMthdNm(String rsrvtnPrceReMkngMthdNm) {
		this.rsrvtnPrceReMkngMthdNm = rsrvtnPrceReMkngMthdNm;
	}
	public String getArsltApplDocRcptMthdNm() {
		return arsltApplDocRcptMthdNm;
	}
	public void setArsltApplDocRcptMthdNm(String arsltApplDocRcptMthdNm) {
		this.arsltApplDocRcptMthdNm = arsltApplDocRcptMthdNm;
	}
	public String getArsltApplDocRcptDt() {
		return arsltApplDocRcptDt;
	}
	public void setArsltApplDocRcptDt(String arsltApplDocRcptDt) {
		this.arsltApplDocRcptDt = arsltApplDocRcptDt;
	}
	public String getOrderPlanUntyNo() {
		return orderPlanUntyNo;
	}
	public void setOrderPlanUntyNo(String orderPlanUntyNo) {
		this.orderPlanUntyNo = orderPlanUntyNo;
	}
	public String getSucsfbidLwltRate() {
		return sucsfbidLwltRate;
	}
	public void setSucsfbidLwltRate(String sucsfbidLwltRate) {
		this.sucsfbidLwltRate = sucsfbidLwltRate;
	}
	public String getRgstDt() {
		return rgstDt;
	}
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}
	public String getBfSpecRgstNo() {
		return bfSpecRgstNo;
	}
	public void setBfSpecRgstNo(String bfSpecRgstNo) {
		this.bfSpecRgstNo = bfSpecRgstNo;
	}
	public String getInfoBizYn() {
		return infoBizYn;
	}
	public void setInfoBizYn(String infoBizYn) {
		this.infoBizYn = infoBizYn;
	}
	public String getSucsfbidMthdCd() {
		return sucsfbidMthdCd;
	}
	public void setSucsfbidMthdCd(String sucsfbidMthdCd) {
		this.sucsfbidMthdCd = sucsfbidMthdCd;
	}
	public String getSucsfbidMthdNm() {
		return sucsfbidMthdNm;
	}
	public void setSucsfbidMthdNm(String sucsfbidMthdNm) {
		this.sucsfbidMthdNm = sucsfbidMthdNm;
	}
	public String getChgDt() {
		return chgDt;
	}
	public void setChgDt(String chgDt) {
		this.chgDt = chgDt;
	}
	public String getLinkInsttNm() {
		return linkInsttNm;
	}
	public void setLinkInsttNm(String linkInsttNm) {
		this.linkInsttNm = linkInsttNm;
	}
	public String getDminsttOfclEmailAdrs() {
		return dminsttOfclEmailAdrs;
	}
	public void setDminsttOfclEmailAdrs(String dminsttOfclEmailAdrs) {
		this.dminsttOfclEmailAdrs = dminsttOfclEmailAdrs;
	}
	public String getIndstrytyLmtYn() {
		return indstrytyLmtYn;
	}
	public void setIndstrytyLmtYn(String indstrytyLmtYn) {
		this.indstrytyLmtYn = indstrytyLmtYn;
	}
	public String getD2bMngDcmtgOprtnDt() {
		return d2bMngDcmtgOprtnDt;
	}
	public void setD2bMngDcmtgOprtnDt(String d2bMngDcmtgOprtnDt) {
		this.d2bMngDcmtgOprtnDt = d2bMngDcmtgOprtnDt;
	}
	public String getD2bMngDcmtgOprtnPlce() {
		return d2bMngDcmtgOprtnPlce;
	}
	public void setD2bMngDcmtgOprtnPlce(String d2bMngDcmtgOprtnPlce) {
		this.d2bMngDcmtgOprtnPlce = d2bMngDcmtgOprtnPlce;
	}
	public String getD2bMngRgnLmtYn() {
		return d2bMngRgnLmtYn;
	}
	public void setD2bMngRgnLmtYn(String d2bMngRgnLmtYn) {
		this.d2bMngRgnLmtYn = d2bMngRgnLmtYn;
	}
	public String getD2bMngPblctPlceNm() {
		return d2bMngPblctPlceNm;
	}
	public void setD2bMngPblctPlceNm(String d2bMngPblctPlceNm) {
		this.d2bMngPblctPlceNm = d2bMngPblctPlceNm;
	}
	public String getD2bMngCntrctKindNm() {
		return d2bMngCntrctKindNm;
	}
	public void setD2bMngCntrctKindNm(String d2bMngCntrctKindNm) {
		this.d2bMngCntrctKindNm = d2bMngCntrctKindNm;
	}
	public String getD2bMngCntrybndDedtBgnDate() {
		return d2bMngCntrybndDedtBgnDate;
	}
	public void setD2bMngCntrybndDedtBgnDate(String d2bMngCntrybndDedtBgnDate) {
		this.d2bMngCntrybndDedtBgnDate = d2bMngCntrybndDedtBgnDate;
	}
	public String getD2bMngCntrybndDedtEndDate() {
		return d2bMngCntrybndDedtEndDate;
	}
	public void setD2bMngCntrybndDedtEndDate(String d2bMngCntrybndDedtEndDate) {
		this.d2bMngCntrybndDedtEndDate = d2bMngCntrybndDedtEndDate;
	}
	public String getD2bMngRsrvtnPrceBssOpenYn() {
		return d2bMngRsrvtnPrceBssOpenYn;
	}
	public void setD2bMngRsrvtnPrceBssOpenYn(String d2bMngRsrvtnPrceBssOpenYn) {
		this.d2bMngRsrvtnPrceBssOpenYn = d2bMngRsrvtnPrceBssOpenYn;
	}
	public String getD2bMngRrsrvtnPrceBssAplYn() {
		return d2bMngRrsrvtnPrceBssAplYn;
	}
	public void setD2bMngRrsrvtnPrceBssAplYn(String d2bMngRrsrvtnPrceBssAplYn) {
		this.d2bMngRrsrvtnPrceBssAplYn = d2bMngRrsrvtnPrceBssAplYn;
	}
	public String getD2bMngBssamt() {
		return d2bMngBssamt;
	}
	public void setD2bMngBssamt(String d2bMngBssamt) {
		this.d2bMngBssamt = d2bMngBssamt;
	}
	public String getD2bMngRgstEvalExmpYn() {
		return d2bMngRgstEvalExmpYn;
	}
	public void setD2bMngRgstEvalExmpYn(String d2bMngRgstEvalExmpYn) {
		this.d2bMngRgstEvalExmpYn = d2bMngRgstEvalExmpYn;
	}
	public String getD2bMngCompCorpRsrchObjYn() {
		return d2bMngCompCorpRsrchObjYn;
	}
	public void setD2bMngCompCorpRsrchObjYn(String d2bMngCompCorpRsrchObjYn) {
		this.d2bMngCompCorpRsrchObjYn = d2bMngCompCorpRsrchObjYn;
	}
	public String getD2bMngOrgnlbdgtDedtBgnDate() {
		return d2bMngOrgnlbdgtDedtBgnDate;
	}
	public void setD2bMngOrgnlbdgtDedtBgnDate(String d2bMngOrgnlbdgtDedtBgnDate) {
		this.d2bMngOrgnlbdgtDedtBgnDate = d2bMngOrgnlbdgtDedtBgnDate;
	}
	public String getD2bMngOrgnlbdgtDedtEndDate() {
		return d2bMngOrgnlbdgtDedtEndDate;
	}
	public void setD2bMngOrgnlbdgtDedtEndDate(String d2bMngOrgnlbdgtDedtEndDate) {
		this.d2bMngOrgnlbdgtDedtEndDate = d2bMngOrgnlbdgtDedtEndDate;
	}
	public String getD2bMngAssmntUplmtRt() {
		return d2bMngAssmntUplmtRt;
	}
	public void setD2bMngAssmntUplmtRt(String d2bMngAssmntUplmtRt) {
		this.d2bMngAssmntUplmtRt = d2bMngAssmntUplmtRt;
	}
	public String getD2bMngAssmntLwstlmtRt() {
		return d2bMngAssmntLwstlmtRt;
	}
	public void setD2bMngAssmntLwstlmtRt(String d2bMngAssmntLwstlmtRt) {
		this.d2bMngAssmntLwstlmtRt = d2bMngAssmntLwstlmtRt;
	}
	public String getD2bMngStdIndstryClsfcCdList() {
		return d2bMngStdIndstryClsfcCdList;
	}
	public void setD2bMngStdIndstryClsfcCdList(String d2bMngStdIndstryClsfcCdList) {
		this.d2bMngStdIndstryClsfcCdList = d2bMngStdIndstryClsfcCdList;
	}
	public String getD2bMngPrdctnAbltySbmsnClseDt() {
		return d2bMngPrdctnAbltySbmsnClseDt;
	}
	public void setD2bMngPrdctnAbltySbmsnClseDt(String d2bMngPrdctnAbltySbmsnClseDt) {
		this.d2bMngPrdctnAbltySbmsnClseDt = d2bMngPrdctnAbltySbmsnClseDt;
	}
	public String getD2bMngProgrsSttusNm() {
		return d2bMngProgrsSttusNm;
	}
	public void setD2bMngProgrsSttusNm(String d2bMngProgrsSttusNm) {
		this.d2bMngProgrsSttusNm = d2bMngProgrsSttusNm;
	}
	public String getD2bMngExetTyNm() {
		return d2bMngExetTyNm;
	}
	public void setD2bMngExetTyNm(String d2bMngExetTyNm) {
		this.d2bMngExetTyNm = d2bMngExetTyNm;
	}
	public String getD2bMngExetTyCd() {
		return d2bMngExetTyCd;
	}
	public void setD2bMngExetTyCd(String d2bMngExetTyCd) {
		this.d2bMngExetTyCd = d2bMngExetTyCd;
	}
	public String getD2bMngPrdlstCd() {
		return d2bMngPrdlstCd;
	}
	public void setD2bMngPrdlstCd(String d2bMngPrdlstCd) {
		this.d2bMngPrdlstCd = d2bMngPrdlstCd;
	}
	public String getD2bMngItemNo() {
		return d2bMngItemNo;
	}
	public void setD2bMngItemNo(String d2bMngItemNo) {
		this.d2bMngItemNo = d2bMngItemNo;
	}
	public String getD2bMngNgttnStleNm() {
		return d2bMngNgttnStleNm;
	}
	public void setD2bMngNgttnStleNm(String d2bMngNgttnStleNm) {
		this.d2bMngNgttnStleNm = d2bMngNgttnStleNm;
	}
	public String getD2bMngNgttnPlanDate() {
		return d2bMngNgttnPlanDate;
	}
	public void setD2bMngNgttnPlanDate(String d2bMngNgttnPlanDate) {
		this.d2bMngNgttnPlanDate = d2bMngNgttnPlanDate;
	}
	public String getD2bMngDmndYear() {
		return d2bMngDmndYear;
	}
	public void setD2bMngDmndYear(String d2bMngDmndYear) {
		this.d2bMngDmndYear = d2bMngDmndYear;
	}
	public String getD2bMngDcsnNo() {
		return d2bMngDcsnNo;
	}
	public void setD2bMngDcsnNo(String d2bMngDcsnNo) {
		this.d2bMngDcsnNo = d2bMngDcsnNo;
	}
	public String getChgNtceRsn() {
		return chgNtceRsn;
	}
	public void setChgNtceRsn(String chgNtceRsn) {
		this.chgNtceRsn = chgNtceRsn;
	}
	public String getRbidOpengDt() {
		return rbidOpengDt;
	}
	public void setRbidOpengDt(String rbidOpengDt) {
		this.rbidOpengDt = rbidOpengDt;
	}
	public String getVAT() {
		return VAT;
	}
	public void setVAT(String vAT) {
		VAT = vAT;
	}
	public String getIndutyVAT() {
		return indutyVAT;
	}
	public void setIndutyVAT(String indutyVAT) {
		this.indutyVAT = indutyVAT;
	}
	
	
}

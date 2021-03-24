package com.kh.toy.mgmtfee.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.mgmtfee.model.vo.Mgmtfee;

public interface MgmtfeeService {
	
	List<Mgmtfee> mgmtfeeUpload(MultipartFile file);

}

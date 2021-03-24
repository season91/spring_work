package common.util.file;

import java.sql.Date;

import common.code.Configcode;

public class FileVo {
	// file 테이블의 vo이다!
		private int fIdx;
		private String typeIdx;
		private String originFileName;
		private String renameFileName;
		private String savePath;
		private Date regDate;
		private int isDel;
		
		// 저장경로랑헷갈려서 풀 경로따로 확인하기 위한 확인용메서드
		public String getFullPath() {
			return Configcode.UPLOAD_PATH + savePath;
		}

		public int getfIdx() {
			return fIdx;
		}

		public void setfIdx(int fIdx) {
			this.fIdx = fIdx;
		}

		public String getTypeIdx() {
			return typeIdx;
		}

		public void setTypeIdx(String typeIdx) {
			this.typeIdx = typeIdx;
		}

		public String getOriginFileName() {
			return originFileName;
		}

		public void setOriginFileName(String originFileName) {
			this.originFileName = originFileName;
		}

		public String getRenameFileName() {
			return renameFileName;
		}

		public void setRenameFileName(String renameFileName) {
			this.renameFileName = renameFileName;
		}

		public String getSavePath() {
			return savePath;
		}
		
		public void setSavePath(String savePath) {
			this.savePath = savePath;
		}

		public Date getRegDate() {
			return regDate;
		}

		public void setRegDate(Date regDate) {
			this.regDate = regDate;
		}

		public int getIsDel() {
			return isDel;
		}

		public void setIsDel(int isDel) {
			this.isDel = isDel;
		}


		@Override
		public String toString() {
			return "FileVo [fIdx=" + fIdx + ", typeIdx=" + typeIdx + ", originFileName=" + originFileName
					+ ", renameFileName=" + renameFileName + ", savePath=" + savePath + ", regDate=" + regDate + ", isDel="
					+ isDel + "]";
		}
}

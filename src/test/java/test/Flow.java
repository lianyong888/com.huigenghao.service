package test;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "core_flow")
public class Flow implements Serializable{
	private static final long serialVersionUID = -7647365120732765617L;
	
	public static class FileObj{
		private String fileName;
		private String fileType;
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getFileType() {
			return fileType;
		}
		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
	}
	
	@Id
	private String id;
	private String tit;
	private Integer sort;
	private List<String> files;
	private List<FileObj> fileObjs;
	
	
	private String detai;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public List<String> getFiles() {
		return files;
	}
	public void setFiles(List<String> files) {
		this.files = files;
	}
	public String getDetai() {
		return detai;
	}
	public void setDetai(String detai) {
		this.detai = detai;
	}
	public List<FileObj> getFileObjs() {
		return fileObjs;
	}
	public void setFileObjs(List<FileObj> fileObjs) {
		this.fileObjs = fileObjs;
	}
}

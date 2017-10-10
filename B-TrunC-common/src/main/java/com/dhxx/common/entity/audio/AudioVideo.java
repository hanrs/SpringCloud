package com.dhxx.common.entity.audio;

import java.util.Date;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 音像记录表 (TB_AUDIO_VIDEO)
 */
public class AudioVideo {
    private Long id; //主键
    private String udn; //主叫用户号码
    private String callerUdn; //被叫用户号码
    private String fileName; //文件名称
    private Double fileSize; //文件大小
    private String filePath; //文件路径
    private Integer recDuration; //录制时长（s）
    private Integer type; //记录类型（0录音文件夹，1照片文件夹2录像文件夹）
    private Date createTime; //开始时间

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }

    public String getCallerUdn() { return callerUdn; }

    public void setCallerUdn(String callerUdn) { this.callerUdn = callerUdn; }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public Double getFileSize() { return fileSize; }

    public void setFileSize(Double fileSize) { this.fileSize = fileSize; }

    public String getFilePath() { return filePath; }

    public void setFilePath(String filePath) { this.filePath = filePath; }

    public Integer getRecDuration() { return recDuration; }

    public void setRecDuration(Integer recDuration) { this.recDuration = recDuration; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public Date getCreateTime() { return createTime; }

    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}

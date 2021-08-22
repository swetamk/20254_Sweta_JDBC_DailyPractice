package com.sonata.jobtracker.model;
import java.util.Date;

public class Task {
private int taskId;
private int ownerId;
private String name;
private String description;
private String status;
private String priority;
private String notes;
private Boolean isBookmarked;
private Date createdOn;
private Date statusChangedOn;
public Task(int taskId, int ownerId, String string, String name, String description, String status, String priority,
String notes, Boolean isBookmarked, Date createdOn, Date statusChangedOn) {
super();
this.taskId = taskId;
this.ownerId = ownerId;
this.name = name;
this.description = description;
this.status = status;
this.priority = priority;
this.notes = notes;
this.isBookmarked = isBookmarked;
this.createdOn = createdOn;
this.statusChangedOn = statusChangedOn;
}
public int getTaskId() {
return taskId;
}
public void setTaskId(int taskId) {
this.taskId = taskId;
}
public int getOwnerId() {
return ownerId;
}
public void setOwnerId(int ownerId) {
this.ownerId = ownerId;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getDescription() {
return description;
}
public void setDescription(String description) {
this.description = description;
}
public String getStatus() {
return status;
}
public void setStatus(String status) {
this.status = status;
}
public String getPriority() {
return priority;
}
public void setPriority(String priority) {
this.priority = priority;
}
public String getNotes() {
return notes;
}
public void setNotes(String notes) {
this.notes = notes;
}
public Boolean getIsBookmarked() {
return isBookmarked;
}
public void setIsBookmarked(Boolean isBookmarked) {
this.isBookmarked = isBookmarked;
}
public Date getCreatedOn() {
return createdOn;
}
public void setCreatedOn(Date createdOn) {
this.createdOn = createdOn;
}
public Date getStatusChangedOn() {
return statusChangedOn;
}
public void setStatusChangedOn(Date statusChangedOn) {
this.statusChangedOn = statusChangedOn;
}
@Override
public String toString() {
return "Task [taskId=" + taskId + ", ownerId=" + ownerId + " , name=" + name
+ ", description=" + description + ", status=" + status + ", priority=" + priority + ", notes=" + notes
+ ", isBookmarked=" + isBookmarked + ", createdOn=" + createdOn + ", statusChangedOn=" + statusChangedOn
+ "]";
}
}
package com.upgrad.ecommerce.domain.v3;

import java.util.ArrayList;
import java.util.Date;

public abstract class StorableWebObject implements WebObject {

  private long id;
  private Date dateCreated;
  private Date lastUpdated;
  
  private String key;
  protected String uuid;
  /** Managing images using ArrayList **/
  private ArrayList<Image> images;

  public StorableWebObject(String key) {
    this.key = key;
    this.dateCreated = new Date();
    this.lastUpdated = new Date();
    this.images = new ArrayList<Image>();
    this.generateUUID();
  }
  
  protected void generateUUID() {
    this.uuid = this.key.replaceAll(" ", "-");
  }
  
  @Override
  public String getUUID() {
    return this.uuid;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }
  
  protected void updateLastUpdated() {
    this.lastUpdated = new Date();
  }

  public ArrayList<Image> getImages() {
    return images;
  }

  public void setImages(ArrayList<Image> images) {
    this.images = images;
  }
  
  /** Adding an image becomes very simple. **/
  public void addImage(Image image) {
    this.images.add(image);
  }
  
  /** Implementation of getting default image is also similar **/
  public Image getDefaultImage() {
    for (int i = 0; i < this.images.size(); i++) {
      if (this.images.get(i).isDefaultImg()) {
        return this.images.get(i);
      }
    }
    return null;
  }
  
  public abstract void preUpdate();
  
  public abstract void preInsert();
}
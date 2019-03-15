package com.upgrad.ecommerce.domain.v1;

public class BrandV1 {
  
  private String name;
  private String description;
  /** Java native array to store brand images **/
  private Image[] images;

  /** Constructor **/
  public BrandV1(String name) {
    this.name = name;
    /** Initialization of array is required **/
    this.images = new Image[3];
  }
  
  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Image[] getImages() {
    return images;
  }

  public void setImages(Image[] images) {
    this.images = images;
  }
  
  /** Method addImage. This iterates over the images array, if the array index is null the value is set. **/
  public void addImage(Image image) {
    for (int i = 0; i < this.images.length; i++) {
      if (null == this.images[i]) {
        this.images[i] = image;
        return;
      }
    }
  }
  
  /** Method getDefaultImage returns the default image of the Brand **/
  public Image getDefaultImage() {
    for (int i = 0; i < this.images.length; i++) {
      if (this.images[i].isDefaultImg()) {
        return this.images[i];
      }
    }
    return null;
  }
}
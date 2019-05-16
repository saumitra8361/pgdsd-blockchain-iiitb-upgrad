package com.upgrad.ecommerce.domain.v3;

public class BrandV3 extends StorableWebObject {

  private String name;
  private String description;

  public BrandV3(String name) {
    super(name);
    this.name = name;
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

  @Override
  public void preUpdate() {
    super.generateUUID();
    super.updateLastUpdated();
  }

  @Override
  public void preInsert() {
    super.generateUUID();
    super.updateLastUpdated();
  }

  /** Class specific implementation of equals **/
  public boolean equals(Object object) {
    if (object instanceof BrandV3) {
      return this.getUUID().equals(((BrandV3) object).getUUID());
    }
    return false;
  }
  
  /** Class specific implementation of hashCode **/
  public int hashCode() {
    return this.getUUID().hashCode();
  }
}

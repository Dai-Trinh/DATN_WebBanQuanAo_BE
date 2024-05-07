package com.datn.atino.domain;


import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends AbstractAuditingEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "is_visible")
    private Boolean isVisible;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Transient
    private CategoryEntity categoryParent;

    @Transient
    private List<CategoryEntity> categoryChild;


    public CategoryEntity() {
    }

    @QueryProjection
    public CategoryEntity(Integer id, String categoryName, Boolean isVisible, CategoryEntity categoryParent) {
        this.id = id;
        this.categoryName = categoryName;
        this.isVisible = isVisible;
        this.categoryParent = categoryParent;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getVisible() {
        return isVisible;
    }

    public void setVisible(Boolean visible) {
        isVisible = visible;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public CategoryEntity getCategoryParent() {
        return categoryParent;
    }

    public void setCategoryParent(CategoryEntity categoryParent) {
        this.categoryParent = categoryParent;
    }

    public List<CategoryEntity> getCategoryChild() {
        return categoryChild;
    }

    public void setCategoryChild(List<CategoryEntity> categoryChild) {
        this.categoryChild = categoryChild;
    }
}

package com.example.workautoapplication.data

import com.example.workautoapplication.domain.AutoItem

class AutoListMapper {

    fun mapEntityToDbModel(autoItem: AutoItem) = AutoItemDbModel(
        brand = autoItem.brand,
        model = autoItem.model,
        price = autoItem.price,
        id = autoItem.id
    )
    fun mapDbModelToEntity(autoItemDbModel: AutoItemDbModel) = AutoItem(
        brand = autoItemDbModel.brand,
        model = autoItemDbModel.model,
        price = autoItemDbModel.price,
        id = autoItemDbModel.id
    )

    fun mapListDbModelToListEntity(list: List<AutoItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

}
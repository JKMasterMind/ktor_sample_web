package com.example.data.model.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object CardTable: Table() {
    val id: Column<Int> = integer("card_id").autoIncrement()
    val owner: Column<Int> = integer("card_owner").references(UserTable.id)
    val cardTitle: Column<String> = varchar("card_title", 50)
    val cardDescription: Column<String> = varchar("card_description", 2000)
    val cardDate: Column<String> = varchar("card_create_date", 50)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
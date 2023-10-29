package com.cesur.pedidos.domain.daos;

import com.cesur.pedidos.domain.entidades.Item;

import java.util.List;

public interface ItemDAO {
    public List<Item> loadItemsByCode(String code);
}

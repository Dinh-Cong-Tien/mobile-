const Item = require('../models/itemModel');

exports.getAllItems = async (req, res) => {
    try {
        console.log("Attempting to fetch all items...");
        const items = await Item.getAll();
        console.log(`Successfully fetched ${items.length} items`);
        res.json(items);
    } catch (err) {
        console.error("BACKEND ERROR:", err); // Dòng này sẽ hiện lỗi chi tiết ở terminal Node.js
        res.status(500).json({ error: err.message });
    }
};

exports.getItemById = async (req, res) => {
    try {
        const item = await Item.getById(req.params.id);
        if (!item) return res.status(404).json({ message: 'Item not found' });
        res.json(item);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
};

exports.createItem = async (req, res) => {
    try {
        const { name, price, quantity } = req.body;
        const newItem = await Item.create(name, price, quantity);
        res.status(201).json(newItem);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
};

exports.updateItem = async (req, res) => {
    try {
        const { name, price, quantity } = req.body;
        const updatedItem = await Item.update(req.params.id, name, price, quantity);
        if (!updatedItem) return res.status(404).json({ message: 'Item not found' });
        res.json(updatedItem);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
};

exports.deleteItem = async (req, res) => {
    try {
        await Item.delete(req.params.id);
        res.json({ message: 'Deleted' });
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
};

const pool = require('../config/db');

const Item = {
    getAll: async () => {
        const result = await pool.query('SELECT * FROM items ORDER BY id ASC');
        return result.rows;
    },
    getById: async (id) => {
        const result = await pool.query('SELECT * FROM items WHERE id = $1', [id]);
        return result.rows[0];
    },
    create: async (name, price, quantity) => {
        const result = await pool.query(
            'INSERT INTO items (name, price, quantity) VALUES ($1, $2, $3) RETURNING *',
            [name, price, quantity]
        );
        return result.rows[0];
    },
    update: async (id, name, price, quantity) => {
        const result = await pool.query(
            'UPDATE items SET name = $1, price = $2, quantity = $3 WHERE id = $4 RETURNING *',
            [name, price, quantity, id]
        );
        return result.rows[0];
    },
    delete: async (id) => {
        await pool.query('DELETE FROM items WHERE id = $1', [id]);
        return { message: 'Item deleted successfully' };
    }
};

module.exports = Item;

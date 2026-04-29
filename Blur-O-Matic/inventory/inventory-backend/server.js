require('dotenv').config();
const express = require('express');
const cors = require('cors');
const itemRoutes = require('./routes/itemRoutes');

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json());

// Routes
app.use('/api/items', itemRoutes);

app.get('/', (req, res) => {
    res.send('Inventory API is running...');
});

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});

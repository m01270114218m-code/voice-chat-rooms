const express = require("express");
const http = require("http");
const cors = require("cors");
const jwt = require("jsonwebtoken");
const { Server } = require("socket.io");

const app = express();
const server = http.createServer(app);
const io = new Server(server, {
  cors: {
    origin: "*",
    methods: ["GET", "POST"]
  }
});

const PORT = 3001;
const JWT_SECRET = "voicehub_super_secret_key_prod";

app.use(cors());
app.use(express.json());

app.get("/health", (req, res) => {
  res.json({ status: "ok", message: "VoiceHub backend is running" });
});

app.post("/api/auth/login", (req, res) => {
  const { email, password } = req.body;

  if (!email || !password) {
    return res.status(400).json({ error: "Email and password required" });
  }

  const token = jwt.sign({ email }, JWT_SECRET, { expiresIn: "7d" });

  res.json({
    token,
    user: {
      email,
      name: "Demo User"
    }
  });
});

app.post("/api/auth/register", (req, res) => {
  const { name, email, password } = req.body;

  if (!name || !email || !password) {
    return res.status(400).json({ error: "All fields are required" });
  }

  const token = jwt.sign({ email, name }, JWT_SECRET, { expiresIn: "7d" });

  res.json({
    token,
    user: {
      name,
      email
    }
  });
});

app.get("/api/rooms", (req, res) => {
  const rooms = [
    { id: "1", name: "غرفة 1", type: "مباشر", members: 120 },
    { id: "2", name: "غرفة 2", type: "VIP", members: 88 },
    { id: "3", name: "غرفة 3", type: "محادثة", members: 214 },
    { id: "4", name: "غرفة 4", type: "مفتوح", members: 170 }
  ];
  res.json(rooms);
});

io.on("connection", (socket) => {
  console.log("Connected:", socket.id);

  socket.on("join:room", (payload) => {
    const { roomId, username } = payload;
    socket.join(roomId);

    io.to(roomId).emit("user:joined", {
      userId: socket.id,
      username,
      roomId
    });
  });

  socket.on("leave:room", (payload) => {
    const { roomId } = payload;
    socket.leave(roomId);
    io.to(roomId).emit("user:left", {
      userId: socket.id
    });
  });

  socket.on("message:send", (payload) => {
    const { roomId, username, text } = payload;
    io.to(roomId).emit("message:received", {
      userId: socket.id,
      username,
      text
    });
  });

  socket.on("toggle:mic", (payload) => {
    const { roomId, username, micEnabled } = payload;
    io.to(roomId).emit("mic:changed", {
      userId: socket.id,
      username,
      micEnabled
    });
  });

  socket.on("disconnect", () => {
    console.log("Disconnected:", socket.id);
  });
});

server.listen(PORT, () => {
  console.log(`VoiceHub server running on http://localhost:${PORT}`);
});

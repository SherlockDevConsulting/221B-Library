-- Initial baseline
CREATE TABLE IF NOT EXISTS book (
    id UUID PRIMARY KEY,
    title TEXT NOT NULL,
    author TEXT,
    isbn TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

import { BrowserRouter, Routes, Route } from "react-router-dom";
import MainLayout from "../layouts/MainLayout";
import Dashboard from "../pages/Dashboard";
import UploadPage from "../pages/UploadPage";
import HistoryPage from "../pages/HistoryPages";
import DetailsPage from "../pages/DetailsPage";

export default function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<MainLayout />}>
          <Route path="/" element={<Dashboard />} />
          <Route path="/upload" element={<UploadPage />} />
          <Route path="/history" element={<HistoryPage />} />
          <Route path="/details/:domain" element={<DetailsPage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
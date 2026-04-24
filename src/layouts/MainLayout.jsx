import { Outlet } from "react-router-dom";
import Sidebar from "./Sidebar";
import Header from "./Header";

export default function MainLayout() {
  return (
    <div className="flex min-h-screen bg-slate-950 text-white">
      
      <Sidebar />

      <div className="flex-1 flex flex-col ml-64">
        <Header />

        <main className="p-8 bg-slate-950 min-h-screen">
          <Outlet />
        </main>
      </div>

    </div>
  );
}
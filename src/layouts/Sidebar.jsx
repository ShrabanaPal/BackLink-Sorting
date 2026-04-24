import { Link, useLocation } from "react-router-dom";

export default function Sidebar() {
  const { pathname } = useLocation();

  const menu = [
    { name: "Dashboard", path: "/" },
    { name: "Upload CSV", path: "/upload" },
    { name: "History", path: "/history" },
  ];

  return (
    <aside className="fixed left-0 top-0 w-64 h-screen bg-slate-900 border-r border-slate-800 p-6">

      <h1 className="text-2xl font-bold text-sky-400 mb-10">
        BackLink Validator
      </h1>

      <nav className="space-y-3">
        {menu.map((item) => (
          <Link
            key={item.path}
            to={item.path}
            className={`block px-4 py-3 rounded-xl transition ${
              pathname === item.path
                ? "bg-sky-500 text-slate-950 font-semibold"
                : "text-slate-300 hover:bg-slate-800 hover:text-white"
            }`}
          >
            {item.name}
          </Link>
        ))}
      </nav>

    </aside>
  );
}
import { useEffect, useState } from "react";
import api from "../api/axios";
import StatsCard from "../dashboard/StatsCard";

export default function Dashboard() {

  const [stats, setStats] = useState({
    total: 0,
    valid: 0,
    broken: 0
  });

  useEffect(() => {
    api.get("/dashboard").then(res => setStats(res.data));
  }, []);

  return (
    <div>
      <h1 className="text-4xl font-bold mb-8">
        Dashboard
      </h1>

      <div className="grid grid-cols-3 gap-6">
        <StatsCard title="Total Uploads" value={stats.total} />
        <StatsCard title="Valid Links" value={stats.valid} />
        <StatsCard title="Broken Links" value={stats.broken} />
      </div>
    </div>
  );
}
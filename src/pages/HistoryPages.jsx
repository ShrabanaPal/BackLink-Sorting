import { useEffect, useState } from "react";
import api from "../api/axios";
import CategoryTabs from "../history/CategoryTabs";
import CategorySection from "../history/CategorySection";
import CaptchaGate from "../security/CaptchaGate";

export default function HistoryPage() {

  const [links, setLinks] = useState([]);
  const [category, setCategory] = useState("SOCIAL_MEDIA");
  const [verified, setVerified] = useState(false);

  useEffect(() => {
    api.get("/history").then(res => setLinks(res.data));
  }, []);

  if (!verified) {
    return <CaptchaGate onSuccess={() => setVerified(true)} />;
  }

  return (
    <div>

      <h1 className="text-3xl font-bold mb-6">
        Categorized History
      </h1>

      <CategoryTabs category={category} setCategory={setCategory} />

      <CategorySection links={links} category={category} />

    </div>
  );
}